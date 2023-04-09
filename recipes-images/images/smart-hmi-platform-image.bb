require tdx-reference-minimal-image.bb

SUMMARY = "Smart HMI Platform"
DESCRIPTION = "Embedded Linux image for smart HMI platform based on Qt 6"

inherit populate_sdk_qt5

#Prefix to the resulting deployable tarball name
export IMAGE_BASENAME = "Smart-HMI-Platform"

IMAGE_FEATURES += " \
    weston \
"

IMAGE_INSTALL += " \
    packagegroup-tdx-cli \
    packagegroup-tdx-graphical \
    packagegroup-tdx-qt5 \
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
    weston-xwayland \
    xterm \
    \
    cuteradio \
    wayland-cuteradio \
"
