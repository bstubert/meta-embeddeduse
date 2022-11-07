SUMMARY = "Packagegroup which provides most QT5 libraries and a QT5 demo"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES += " \
    ${PN}-fonts \
    ${PN}-libs \
"

RRECOMMENDS_${PN} = " \
    ${PN}-fonts \
    ${PN}-libs \
"

SUMMARY_${PN}-fonts = "Some fonts useful for QT5"
RRECOMMENDS_${PN}-fonts = " \
    ttf-dejavu-common \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-serif \
"

SUMMARY_${PN}-libs = "QT5 libraries"
RRECOMMENDS_${PN}-libs = " \
    qt3d \
    qtbase \
    qtconnectivity \
    qtdeclarative \
    qtgraphicaleffects \
    qtimageformats \
    qtlocation \
    qtmultimedia \
    qtquickcontrols2 \
    qtquicktimeline \
    qtremoteobjects \
    qtscxml \
    qtsensors \
    qtserialbus \
    qtserialport \
    qtsvg \
    qtsystems \
    qttools \
    qttranslations \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    qtwebchannel \
    qtwebsockets \
    qtxmlpatterns \
"

