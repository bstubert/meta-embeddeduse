#!/bin/sh

echo "Running preinstall.sh $1 for copy $2" || exit 1
umount $1 || exit 1
mkfs.ext4 $1 -F -L $2 -q || exit 1
