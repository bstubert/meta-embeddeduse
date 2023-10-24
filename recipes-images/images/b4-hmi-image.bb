DESCRIPTION = "Extension of Freescale Image: Single Qt5 app started by Weston"
LICENSE = "MIT"

require recipes-fsl/images/fsl-image-gui.bb

inherit features_check populate_sdk_qt5

CONFLICT_DISTRO_FEATURES = "directfb"

# Install fonts
QT5_FONTS = " \
    ttf-dejavu-mathtexgyre \
    ttf-dejavu-sans \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-sans-mono \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
"

IMAGE_INSTALL += " \
    ${QT5_FONTS} \
    cuteradio \
    wayland-cuteradio \
    swupdate \
    swupdate-www \
    kernel-image \
    kernel-devicetree \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland qtwayland-plugins', '', d)} \
"

IMAGE_FSTYPES = "ext4.gz"
