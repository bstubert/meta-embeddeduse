SUMMARY = "Packagegroup which provides most QT5 libraries and a QT5 demo"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES += " \
    ${PN}-demos \
    ${PN}-fonts \
    ${PN}-libs \
"

RRECOMMENDS:${PN} = " \
    ${PN}-demos \
    ${PN}-fonts \
    ${PN}-libs \
"
# Only install qtbase-examples with its dependencies on modules with limited
# storage and no gpu.
RRECOMMENDS:${PN}:colibri-imx6ull = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    qtbase-examples \
"
RRECOMMENDS:${PN}:colibri-imx6ull-emmc = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    qtbase-examples \
"
RRECOMMENDS:${PN}:colibri-imx7 = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    qtbase-examples \
"

SUMMARY:${PN}-demos = "QT5 Demos"
RRECOMMENDS:${PN}-demos = " \
    cinematicexperience \
    qtsmarthome \
"

SUMMARY:${PN}-fonts = "Some fonts useful for QT5"
RRECOMMENDS:${PN}-fonts = " \
    ttf-dejavu-common \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-serif \
"

SUMMARY:${PN}-libs = "QT5 libraries"
RRECOMMENDS:${PN}-libs = " \
    qt3d \
    qt5ledscreen \
    qtbase \
    qtcharts \
    qtcoap \
    qtconnectivity \
    qtdatavis3d \
    qtdeclarative \
    qtgamepad \
    qtgraphicaleffects \
    qtimageformats \
    qtknx \
    qtlocation \
    qtlottie \
    qtmqtt \
    qtmultimedia \
    qtnetworkauth \
    qtopcua \
    qtpurchasing \
    qtquick3d \
    qtquickcontrols \
    qtquickcontrols2 \
    qtquicktimeline \
    qtremoteobjects \
    qtscript \
    qtscxml \
    qtsensors \
    qtserialbus \
    qtserialport \
    qtsvg \
    qtsystems \
    qttools \
    qttranslations \
    qtvirtualkeyboard \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    qtwebchannel \
    qtwebglplugin \
    qtwebsockets \
    qtxmlpatterns \
"

