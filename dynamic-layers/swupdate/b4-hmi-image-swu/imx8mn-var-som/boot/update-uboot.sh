#!/bin/bash

if [ $# -ne 1 ]; then
    echo "ERROR: Usage: update-uboot.sh 0|1>"
    exit 1
fi

bootpart=$1
bootimg="/home/root/uboot.bin"

echo "Updating uboot in boot partition ${bootpart}"

if [ ! -f ${bootimg} ]; then
    echo "INFO: U-boot update not needed."
    exit 0
fi

echo 0 > /sys/class/block/mmcblk2boot${bootpart}/force_ro || exit 1
dd if=${bootimg} of=/dev/mmcblk2boot${bootpart} || exit 1
sync || exit 1
echo 1 > /sys/class/block/mmcblk2boot${bootpart}/force_ro || exit 1

rm -f ${bootimg} || exit 1

enablepart=$((bootpart + 1))
mmc bootpart enable ${enablepart} 0 /dev/mmcblk2 || exit 1


