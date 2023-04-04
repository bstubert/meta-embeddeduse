SUMMARY = "Smart HMI Platform"
DESCRIPTION = "Embedded Linux image for smart HMI platform based on Qt 6"
LICENSE = "MIT"

inherit populate_sdk_qt5

#Prefix to the resulting deployable tarball name
export IMAGE_BASENAME = "Smart-HMI-Platform"
MACHINE_NAME ?= "${MACHINE}"
IMAGE_NAME = "${MACHINE_NAME}_${IMAGE_BASENAME}"

# Copy Licenses to image /usr/share/common-license.
# TODO: Uncomment later
#COPY_LIC_MANIFEST ?= "1"
#COPY_LIC_DIRS ?= "1"

add_rootfs_version () {
    printf "${DISTRO_NAME} ${DISTRO_VERSION} (${DISTRO_CODENAME}) \\\n \\\l\n" > ${IMAGE_ROOTFS}/etc/issue
    printf "${DISTRO_NAME} ${DISTRO_VERSION} (${DISTRO_CODENAME}) %%h\n" > ${IMAGE_ROOTFS}/etc/issue.net
    printf "${IMAGE_NAME}\n\n" >> ${IMAGE_ROOTFS}/etc/issue
    printf "${IMAGE_NAME}\n\n" >> ${IMAGE_ROOTFS}/etc/issue.net
}
# add the rootfs version to the welcome banner
ROOTFS_POSTPROCESS_COMMAND += " add_rootfs_version;"

IMAGE_LINGUAS = "en-us"

CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-client"

IMAGE_FEATURES += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11-base', '', d), d)} \
"

APP_LAUNCH_WAYLAND ?= "wayland-qtdemo-launch-cinematicexperience"

IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         '${APP_LAUNCH_WAYLAND}', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', \
                         'weston-xwayland xterm', \
       bb.utils.contains('DISTRO_FEATURES', 'x11', '${APP_LAUNCH_X11}', '', d), d)} \
    \
    packagegroup-base-tdx-cli \
    packagegroup-basic \
    packagegroup-boot \
    packagegroup-fsl-isp \
    packagegroup-machine-tdx-cli \
    packagegroup-tdx-cli \
    packagegroup-tdx-graphical \
    packagegroup-tdx-qt5 \
    packagegroup-wifi-fw-tdx-cli \
    packagegroup-wifi-tdx-cli \
    ${CONMANPKGS} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'timestamp-service systemd-analyze', '', d)} \
    \
    bash \
    coreutils \
    less \
    makedevs \
    mime-support \
    net-tools \
    udev-extraconf \
    util-linux \
    v4l-utils \
    \
    gpicview \
    media-files \
"
