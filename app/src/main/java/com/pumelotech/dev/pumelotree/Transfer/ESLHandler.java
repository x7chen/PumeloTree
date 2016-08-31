package com.pumelotech.dev.pumelotree.Transfer;


import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Log;

import com.pumelotech.dev.pumelotree.MyApplication;
import com.pumelotech.dev.pumelotree.Transfer.CallbackInterface.TransferCallback;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/8/31.
 */
public class ESLHandler implements TransferCallback {

    static private ESLHandler mESLHandler;
    private LeConnector leConnector;
    private final static String TAG = MyApplication.DebugTag;
    public static final UUID ESL_SERVICE_UUID = UUID.fromString("DA1A1800-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID SCREEN_CHAR_UUID = UUID.fromString("DA1A1801-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID ERROR_CHAR_UUID = UUID.fromString("DA1A1802-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID PRICE_CHAR_UUID = UUID.fromString("DA1A1803-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID PRODUCT_ID_CHAR_UUID = UUID.fromString("DA1A1804-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID TYPE_CHAR_UUID = UUID.fromString("DA1A1805-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID CHANNEL_CHAR_UUID = UUID.fromString("DA1A1806-AF00-40C6-BCDA-E093AF5A45DB");
    public static final UUID LOCATION_CHAR_UUID = UUID.fromString("DA1A1807-AF00-40C6-BCDA-E093AF5A45DB");

    private BluetoothGattCharacteristic screenCharacteristic;
    private BluetoothGattCharacteristic errorCharacteristic;
    private BluetoothGattCharacteristic priceCharacteristic;
    private BluetoothGattCharacteristic productCharacteristic;
    private BluetoothGattCharacteristic typeCharacteristic;
    private BluetoothGattCharacteristic channelCharacteristic;
    private BluetoothGattCharacteristic locationCharacteristic;

    private BluetoothGatt mBluetoothGatt;


    private boolean isLastPacket = false;
    private long mFileSize = 0;
    private long mTotalPackets = 0;
    private long mPacketNumber = 0;
    HexInputStream mFileStream;
    private final int BYTES_IN_ONE_PACKET = 20;

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
        if(characteristic.getUuid().equals(ERROR_CHAR_UUID)){

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

    @Override
    public void onCharacteristicWrite(BluetoothGattCharacteristic characteristic) {

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
                            } else if (characteristic.getUuid().equals(ERROR_CHAR_UUID)) {
                                errorCharacteristic = characteristic;
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
    public void readType(){
        mBluetoothGatt.readCharacteristic(typeCharacteristic);
    }

    private void sendPacket() {
        mPacketNumber++;
        //If last packet then send only remaining bytes
        if (mPacketNumber == mTotalPackets) {
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
        }
        // otherwise send packet of 20 bytes
        else {
            screenCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            screenCharacteristic.setValue(getNextPacket());
            mBluetoothGatt.writeCharacteristic(screenCharacteristic);
        }
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
     */
    public void openFile(InputStream stream) {
        try {
            mPacketNumber = 0;
            //HexInputStream class convert file format from Hex to Binary
            mFileStream = new HexInputStream(stream);
            mFileSize = mFileStream.available();
            mTotalPackets = getNumberOfPackets();
            Log.d(TAG, "File Size: " + mFileSize);
        } catch (IOException e) {
            Log.e(TAG, ERROR_FILE_OPEN + " " + e);
        }
    }

    /**
     * close the file stream
     */
    public void closeFile() {
        if (mFileStream != null) {
            try {
                mFileStream.close();
                mFileStream = null;
            } catch (IOException e) {
                Log.e(TAG, ERROR_FILE_CLOSE + " " + e.toString());
            }
        }
    }

    /**
     * reads the next packet with max 20 bytes
     */
    private byte[] getNextPacket() {
        try {
            byte[] buffer = new byte[20];
            mFileStream.readPacket(buffer);
            return buffer;
        } catch (IOException e) {
            Log.e(TAG, ERROR_FILE_READ);
        }
        return null;
    }
}
