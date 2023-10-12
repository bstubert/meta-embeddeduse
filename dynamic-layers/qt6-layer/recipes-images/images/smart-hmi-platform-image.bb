require tdx-reference-minimal-image.bb

SUMMARY = "Smart HMI Platform"
DESCRIPTION = "Embedded Linux image for smart HMI platform based on Qt 6"

inherit populate_sdk_qt6

#Prefix to the resulting deployable tarball name
IMAGE_BASENAME = "Smart-HMI-Platform"
SDK_NAME = "SDK-${MACHINE}-${IMAGE_BASENAME}"

IMAGE_FEATURES += " \
    weston \
"

IMAGE_INSTALL += " \
    packagegroup-tdx-cli \
    packagegroup-tdx-graphical \
    packagegroup-qt-lgpl \
    packagegroup-fsl-isp \
    \
    bash \
    coreutils \
    less \
    makedevs \
    mime-support \
    net-tools \
    util-linux \
    v4l-utils \
    \
    cuteradio \
    wayland-cuteradio \
"
