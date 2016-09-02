package com.pumelotech.dev.pumelotree.transfer.callback;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/**
 * Created by x7che on 2016/7/15.
 */
public interface TransferCallback {
    void onCharacteristicWrite(BluetoothGattCharacteristic characteristic, int status);
    void onCharacteristicRead(BluetoothGattCharacteristic characteristic);
    void onCharacteristicChanged(BluetoothGattCharacteristic characteristic);
    void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status);
}
