require tdx-reference-minimal-image.bb

SUMMARY = "Embedded Linux Smart HMI Image"
DESCRIPTION = "Embedded Linux image with Qt LGPLv3 for smart HMIs"

inherit populate_sdk_qt5

#Prefix to the resulting deployable tarball name
export IMAGE_BASENAME = "Smart-HMI-Image"

SYSTEMD_DEFAULT_TARGET = "graphical.target"

IMAGE_FEATURES += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11', \
                                                       '', d), d)} \
"

APP_LAUNCH_WAYLAND ?= ""
APP_LAUNCH_X11 ?= ""

IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston weston-init weston-examples ${APP_LAUNCH_WAYLAND}', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', \
                         'weston-xwayland xterm', \
       bb.utils.contains('DISTRO_FEATURES', 'x11', '${APP_LAUNCH_X11}', '', d), d)} \
    \
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
    \
    cuteradio \
"
