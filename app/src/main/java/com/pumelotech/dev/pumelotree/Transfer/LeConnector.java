/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pumelotech.dev.pumelotree.Transfer;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.pumelotech.dev.pumelotree.MyApplication;
import com.pumelotech.dev.pumelotree.R;
import com.pumelotech.dev.pumelotree.Transfer.CallbackInterface.ConnectionCallback;
import com.pumelotech.dev.pumelotree.Transfer.CallbackInterface.TransferCallback;

import java.util.List;

/**
 * Service for managing connection and data communication with a GATT server hosted on a
 * given Bluetooth LE device.
 */
public class LeConnector extends BluetoothGattCallback {
    public static final String TAG = MyApplication.DebugTag;

    static private Context mContext;
    static private LeConnector mLeConnector;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothDevice mDevice;
    private List<BluetoothGattService> mServices;
    private String mName;
    private ConnectionCallback mConnectionCallback = new ConnectionCallback() {
        @Override
        public void onConnectionStateChange(int newState) {

        }

        @Override
        public void onError(String message, int errorCode) {

        }

        @Override
        public void onDeviceNotSupported() {

        }
    };
    private TransferCallback mTransferCallback = new TransferCallback() {
        @Override
        public void onCharacteristicWrite(BluetoothGattCharacteristic characteristic) {

        }

        @Override
        public void onCharacteristicRead(BluetoothGattCharacteristic characteristic) {

        }

        @Override
        public void onCharacteristicChanged(BluetoothGattCharacteristic characteristic) {

        }
    };
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_CONNECTED = 2;
    private int mConnectionState = STATE_DISCONNECTED;

    public final static String ERROR_DISCOVERY_SERVICE = "Error on discovering services";
    public final static String ERROR_WRITE_CHARACTERISTIC = "Error on writing characteristic";
    public final static String ERROR_WRITE_DESCRIPTOR = "Error on writing descriptor";


    // Implements callback methods for GATT events that the app cares about.  For example,
    // connection change and services discovered.

    @Override
    public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
        if (newState == BluetoothProfile.STATE_CONNECTED) {
            mConnectionState = STATE_CONNECTED;
            mConnectionCallback.onConnectionStateChange(newState);
            Log.i(TAG, "Connected to GATT server.");
            // Attempts to discover services after successful connection.
            Log.i(TAG, "Attempting to start service discovery:" +
                    mBluetoothGatt.discoverServices());

        } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
            mConnectionState = STATE_DISCONNECTED;
            mConnectionCallback.onConnectionStateChange(newState);
            autoConnect(mName);
        } else if (newState == BluetoothGatt.STATE_CONNECTING) {
        }
    }

    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        if (status == BluetoothGatt.GATT_SUCCESS) {
            mServices = gatt.getServices();
        } else {
            mConnectionCallback.onError(ERROR_DISCOVERY_SERVICE, status);
        }
    }

    @Override
    public void onCharacteristicRead(BluetoothGatt gatt,
                                     BluetoothGattCharacteristic characteristic,
                                     int status) {
        if (status == BluetoothGatt.GATT_SUCCESS) {
            mTransferCallback.onCharacteristicRead(characteristic);
        }
    }

    @Override
    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        mTransferCallback.onCharacteristicWrite(characteristic);
        super.onCharacteristicWrite(gatt, characteristic, status);
    }

    @Override
    public void onCharacteristicChanged(BluetoothGatt gatt,
                                        BluetoothGattCharacteristic characteristic) {
        mTransferCallback.onCharacteristicChanged(characteristic);
    }

    @Override
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        super.onDescriptorWrite(gatt, descriptor, status);
    }

    public BluetoothGatt getBluetoothGatt() {
        return mBluetoothGatt;
    }

    public List<BluetoothGattService> getServices() {
        return mServices;
    }

    public int getmConnectionState() {
        return mConnectionState;
    }

    public BluetoothDevice getDevice() {
        return mDevice;
    }
    public void setConnectionCallback(ConnectionCallback callback) {
        mConnectionCallback = callback;
    }
    public void setTransferCallback(TransferCallback callback) {
        mTransferCallback = callback;
    }

    public void autoConnect(String name, ConnectionCallback callBacks) {
        if(callBacks!=null) {
            setConnectionCallback(callBacks);
        }
        autoConnect(name);
        Log.i(TAG,"autoConnect:"+name);
    }

    private void autoConnect(String name) {
        final String dName = name;
        mBluetoothAdapter.startLeScan(new BluetoothAdapter.LeScanCallback() {
            @Override
            public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
                String deviceName = device.getName();

                if (deviceName == null) {
                    deviceName = LeAdvertiseParser.parseAdertisedData(scanRecord).getName();
                }
                if (deviceName != null && deviceName.equals(dName)) {
                    if (mConnectionState == STATE_DISCONNECTED) {
                        connect(mContext, device);
                        mBluetoothAdapter.stopLeScan(null);
                        mConnectionState = STATE_CONNECTING;
                    }
                }

                Log.d(TAG, "NAME:" + deviceName + "  RSSI:" + rssi);
            }
        });
        Log.d(TAG, "Start Scan");
    }

    private void connect(Context context, BluetoothDevice device) {
        if (device == null) {
            return;
        }
        mDevice = device;

        mBluetoothGatt = mDevice.connectGatt(context, false, this);
    }

    public void disconnect() {
        Log.d(TAG, "Disconnecting device");
        if (mBluetoothGatt != null) {
            mBluetoothGatt.disconnect();
        }
    }

    /**
     * After using a given BLE device, the app must call this method to ensure resources are
     * released properly.
     */
    public void close() {
        if (mBluetoothGatt == null) {
            return;
        }
        mBluetoothGatt.close();
        mBluetoothGatt = null;
    }

    public static LeConnector getInstance(Context context) {
        mContext = context;
        if (mLeConnector == null) {
            mLeConnector = new LeConnector();
        }
        MyApplication.gLeConnector = mLeConnector;
        return mLeConnector;
    }

    public LeConnector() {
        // Initializes a Bluetooth adapter.  For API level 18 and above, get a reference to
        // BluetoothAdapter through BluetoothManager.
        final BluetoothManager bluetoothManager =
                (BluetoothManager) mContext.getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();
        // Checks if Bluetooth is supported on the device.
        if (mBluetoothAdapter == null) {
            Toast.makeText(mContext, R.string.error_bluetooth_not_supported, Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
