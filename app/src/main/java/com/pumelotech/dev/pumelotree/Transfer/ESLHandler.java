package com.pumelotech.dev.pumelotree.transfer;


import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Log;

import com.pumelotech.dev.pumelotree.MyApplication;
import com.pumelotech.dev.pumelotree.transfer.callback.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.UUID;

/**
 * Created by Administrator on 2016/8/31.
 */
public class ESLHandler implements TransferCallback {

    static private ESLHandler mESLHandler;
    private LeConnector leConnector;
    private EslProgressCallback eslProgressCallback;
    private final static String TAG = MyApplication.DebugTag+"ESL";
    public static final UUID ESL_SERVICE_UUID = UUID.fromString("DA1A1800-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID CONTROL_POINT_CHAR_UUID = UUID.fromString("DA1A1801-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID SCREEN_CHAR_UUID = UUID.fromString("DA1A1802-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID PRICE_CHAR_UUID = UUID.fromString("DA1A1803-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID PRODUCT_ID_CHAR_UUID = UUID.fromString("DA1A1804-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID TYPE_CHAR_UUID = UUID.fromString("DA1A1805-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID CHANNEL_CHAR_UUID = UUID.fromString("DA1A1806-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID LOCATION_CHAR_UUID = UUID.fromString("DA1A1807-AF00-40C6-BCDA-E093AF5A45DB");

    private BluetoothGattCharacteristic screenCharacteristic;
    private BluetoothGattCharacteristic controlCharacteristic;
    private BluetoothGattCharacteristic priceCharacteristic;
    private BluetoothGattCharacteristic productCharacteristic;
    private BluetoothGattCharacteristic typeCharacteristic;
    private BluetoothGattCharacteristic channelCharacteristic;
    private BluetoothGattCharacteristic locationCharacteristic;

    private BluetoothGatt mBluetoothGatt;
    private boolean connectionIsReady = false;
    private ArrayList<Byte> screenData = new ArrayList<>();
    private boolean isLastPacket = false;
    private long mFileSize = 0;
    private long mTotalPackets = 0;
    private long mPacketNumber = 0;
    private final int BYTES_IN_ONE_PACKET = 16;

    public final static String ERROR_DISCOVERY_SERVICE = "Error on discovering services";
    public final static String ERROR_WRITE_CHARACTERISTIC = "Error on writing characteristic";
    public final static String ERROR_FILE_LENGTH = "Invalid File Length";
    public final static String ERROR_FILE_TRANSFER = "File transfer failed";
    public final static String ERROR_FILE_VALIDATION = "File validation failed";
    public final static String ERROR_WRITE_DESCRIPTOR = "Error on writing descriptor";
    public final static String ERROR_FILE_OPEN = "Error on openning file";
    public final static String ERROR_FILE_CLOSE = "Error on closing file";
    public final static String ERROR_FILE_READ = "Error on reading file";

    @Override
    public void onCharacteristicChanged(BluetoothGattCharacteristic characteristic) {
        if (characteristic.getUuid().equals(CONTROL_POINT_CHAR_UUID)) {
            byte[] value = characteristic.getValue();
            if (value[0] == 0) {
                if (value[1] == 0) {
                    sendPacket();
                }
            }
        }
    }

    @Override
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        if (descriptor.getCharacteristic() == controlCharacteristic) {
            connectionIsReady = true;
        }
    }

    @Override
    public void onServicesDiscovered() {
        getCharacteristics();
    }

    @Override
    public void onCharacteristicWrite(BluetoothGattCharacteristic characteristic, int status) {
        if (characteristic.getUuid().equals(SCREEN_CHAR_UUID)) {
            sendPacket();
        }

    }

    @Override
    public void onCharacteristicRead(BluetoothGattCharacteristic characteristic) {
        if (characteristic.getUuid().equals(PRICE_CHAR_UUID)) {

        } else if (characteristic.getUuid().equals(PRODUCT_ID_CHAR_UUID)) {

        } else if (characteristic.getUuid().equals(TYPE_CHAR_UUID)) {

        } else if (characteristic.getUuid().equals(CHANNEL_CHAR_UUID)) {

        } else if (characteristic.getUuid().equals(LOCATION_CHAR_UUID)) {

        }
    }


    ESLHandler() {
        leConnector = MyApplication.gLeConnector;

    }

    static public ESLHandler getInstance() {
        if (mESLHandler == null) {
            mESLHandler = new ESLHandler();
        }

        return mESLHandler;
    }
    public void setEslProgressCallback(EslProgressCallback callback){
        eslProgressCallback = callback;
    }
    void getCharacteristics() {
        if (leConnector != null) {
            mBluetoothGatt = leConnector.getBluetoothGatt();
            leConnector.setTransferCallback(this);
            if (leConnector.getmConnectionState() == LeConnector.STATE_CONNECTED) {
                List<BluetoothGattService> services = leConnector.getServices();
                if (services == null || services.isEmpty()) {
                    return;
                }
                for (BluetoothGattService service : services) {
                    if (service.getUuid().equals(ESL_SERVICE_UUID)) {
                        List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
                        for (BluetoothGattCharacteristic characteristic : characteristics) {
                            Log.i(TAG, "CHAR:" + characteristic.getUuid().toString());
                            if (characteristic.getUuid().equals(SCREEN_CHAR_UUID)) {
                                screenCharacteristic = characteristic;
                            } else if (characteristic.getUuid().equals(CONTROL_POINT_CHAR_UUID)) {
                                controlCharacteristic = characteristic;
                                mBluetoothGatt.setCharacteristicNotification(characteristic, true);
                                List<BluetoothGattDescriptor> descriptors = characteristic.getDescriptors();
                                for (BluetoothGattDescriptor dp : descriptors) {
                                    dp.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                    mBluetoothGatt.writeDescriptor(dp);
                                }
                            } else if (characteristic.getUuid().equals(PRICE_CHAR_UUID)) {
                                priceCharacteristic = characteristic;
                            } else if (characteristic.getUuid().equals(PRODUCT_ID_CHAR_UUID)) {
                                productCharacteristic = characteristic;
                            } else if (characteristic.getUuid().equals(TYPE_CHAR_UUID)) {
                                typeCharacteristic = characteristic;
                            } else if (characteristic.getUuid().equals(CHANNEL_CHAR_UUID)) {
                                channelCharacteristic = characteristic;
                            } else if (characteristic.getUuid().equals(LOCATION_CHAR_UUID)) {
                                locationCharacteristic = characteristic;
                            }
                        }
                    }
                }
            }
        }
    }

    public void readPrice() {
        mBluetoothGatt.readCharacteristic(priceCharacteristic);
    }

    public void readType() {
        mBluetoothGatt.readCharacteristic(typeCharacteristic);
    }

    private void sendPacket() {
        mPacketNumber++;
        Log.i(TAG,"sendprogress"+mPacketNumber);
        //If last packet then send only remaining bytes
        if (mPacketNumber > mTotalPackets) {
            Log.d(TAG, "This is last packet, packet number: " + mPacketNumber);
            isLastPacket = true;
            byte[] buffer = getNextPacket();
            byte[] data = new byte[getBytesInLastPacket()];
            for (int i = 0; i < getBytesInLastPacket(); i++) {
                data[i] = buffer[i];
            }
            screenCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            screenCharacteristic.setValue(data);
            mBluetoothGatt.writeCharacteristic(screenCharacteristic);
        } else if (mPacketNumber < mTotalPackets) {           // otherwise send packet of 20 bytes
            //screenCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            screenCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
            screenCharacteristic.setValue(getNextPacket());
            mBluetoothGatt.writeCharacteristic(screenCharacteristic);
        } else {
            byte[] value = new byte[1];
            value[0] = 0x01;
            controlCharacteristic.setValue(value);
            mBluetoothGatt.writeCharacteristic(controlCharacteristic);
        }
        eslProgressCallback.updataProgress((int) (mPacketNumber*100/mTotalPackets));
    }

    private int getNumberOfPackets() {
        int numOfPackets = (int) (mFileSize / BYTES_IN_ONE_PACKET);
        if ((mFileSize % BYTES_IN_ONE_PACKET) > 0) {
            numOfPackets++;
        }
        return numOfPackets;
    }

    private int getBytesInLastPacket() {
        return (int) (mFileSize % BYTES_IN_ONE_PACKET);
    }

    /**
     * Here selected IntelHex file will be converted into Binary format
     * @param data
     */
    public void setScreenData(Byte[] data) {
        screenData.clear();
        for (Byte b : data) {
            screenData.add(b);
        }
        mPacketNumber = 0;
        //HexInputStream class convert file format from Hex to Binary
        mFileSize = data.length;
        mTotalPackets = getNumberOfPackets();
    }


    /**
     * reads the next packet with max 20 bytes
     */
    private byte[] getNextPacket() {
        byte[] buffer = new byte[20];
        List<Byte> sublist;
        if (mPacketNumber == (mTotalPackets - 1)) {
            sublist = screenData.subList((int) mPacketNumber * BYTES_IN_ONE_PACKET, (int) mFileSize);
        } else {
            sublist = screenData.subList((int) mPacketNumber * BYTES_IN_ONE_PACKET, (int) (mPacketNumber + 1) * BYTES_IN_ONE_PACKET);
        }

        buffer[0] = (byte) (mPacketNumber / 256);
        buffer[1] = (byte) mPacketNumber;
        buffer[2] = 0;
        buffer[3] = 0;
        for (int i = 0; i < sublist.size(); i++) {
            buffer[4 + i] = sublist.get(i);
        }

        StringBuilder builder = new StringBuilder();
        for(byte b:buffer) {
            builder.append(String.format("%02X ", b));
        }
        Log.i(TAG,builder.toString());
        return buffer;

    }

    public int startSendScreenData() {
        if (controlCharacteristic == null) {
            getCharacteristics();
        }
        if (!connectionIsReady) {
            return 1;
        }
        byte[] value = new byte[5];
        value[0] = 0x00;
        value[1] = (byte) (screenData.size() / 256);
        value[2] = (byte) screenData.size();
        value[3] = 0x12;
        value[4] = 0x34;
        controlCharacteristic.setValue(value);
        mBluetoothGatt.writeCharacteristic(controlCharacteristic);
        return 0;
    }
}
