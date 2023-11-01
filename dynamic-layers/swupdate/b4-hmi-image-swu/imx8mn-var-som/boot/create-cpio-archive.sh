#!/bin/sh

for file in $@; do
    echo $file
done | cpio -ov -H crc > b4-hmi-image-swu-imx8mn-var-som.swu

