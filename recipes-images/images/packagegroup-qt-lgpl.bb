SUMMARY = "Provides Qt modules under LGPL-3.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES += " \
    ${PN}-fonts \
    ${PN}-libs \
"

RRECOMMENDS:${PN} = " \
    ${PN}-fonts \
    ${PN}-libs \
"

SUMMARY:${PN}-fonts = "Some fonts useful for Qt"
RRECOMMENDS:${PN}-fonts = " \
    ttf-dejavu-common \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-serif \
"

# Add the following modules on demand: qt3d, qtlocation, qtopcua, qtpdf, qtscxml, qtsvg,
# qtwebchannel, qtwebengine, qtwebglplugin, qtwebsockets, qtwebview. They are often not needed in
# typical embedded Linux systems.
SUMMARY:${PN}-libs = "Qt modules under LGPL-3.0"
RRECOMMENDS:${PN}-libs = " \
    qtbase \
    qtconnectivity \
    qtdeclarative \
    qtimageformats \
    qtmultimedia \
    qtremoteobjects \
    qtsensors \
    qtserialbus \
    qtserialport \
    qttools \
    qttranslations \
    qtwayland \
"

