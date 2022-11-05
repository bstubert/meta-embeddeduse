SUMMARY = "Packagegroups which provide cmdline releated packages"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES += " \
    packagegroup-base-tdx-cli \
    packagegroup-benchmark-tdx-cli \
    packagegroup-devel-tdx-cli \
    packagegroup-machine-tdx-cli \
    packagegroup-networking-tdx-cli \
    packagegroup-utils-tdx-cli \
    packagegroup-utils-large-tdx-cli \
    packagegroup-wifi-tdx-cli \
    packagegroup-wifi-fw-tdx-cli \
    packagegroup-wifi-fw-large-tdx-cli \
"

RDEPENDS_packagegroup-tdx-cli = "\
    packagegroup-base-tdx-cli \
    packagegroup-benchmark-tdx-cli \
    packagegroup-devel-tdx-cli \
    packagegroup-machine-tdx-cli \
    packagegroup-networking-tdx-cli \
    packagegroup-utils-tdx-cli \
    packagegroup-utils-large-tdx-cli \
    packagegroup-wifi-tdx-cli \
    packagegroup-wifi-fw-tdx-cli \
    packagegroup-wifi-fw-large-tdx-cli \
"

SUMMARY_packagegroup-base-tdx-cli = "Recommended for any image"
RRECOMMENDS_packagegroup-base-tdx-cli = "\
    can-utils \
    dosfstools \
    e2fsprogs-mke2fs \
    iproute2 \
    libgomp \
    libgpiod-tools \
    libsoc \
    mtd-utils \
    set-hostname \
    u-boot-fw-utils \
    udev-toradex-rules \
    uhubctl \
    util-linux-fstrim \
"

SUMMARY_packagegroup-benchmark-tdx-cli = "Benchmarking tools"
RRECOMMENDS_packagegroup-benchmark-tdx-cli = "\
    hdparm \
    iperf2 \
    iperf3 \
    lmbench \
    memtester \
    nbench-byte \
    rt-tests \
    tinymembench \
"

SUMMARY_packagegroup-devel-tdx-cli = "Tools useful during development"
RRECOMMENDS_packagegroup-devel-tdx-cli = "\
    bonnie++ \
    devmem2 \
    evtest \
    fio \
    gdbserver \
    i2c-tools \
    ldd \
    less \
    perf \
    serial-test \
    smem \
    spitools \
    spidev-test \
    strace \
"
RRECOMMENDS_packagegroup-devel-tdx-cli_remove_use-nxp-bsp_colibri-vf = "perf"

SUMMARY_packagegroup-machine-tdx-cli = "Machine specific tools"
RRECOMMENDS_packagegroup-machine-tdx-cli = "\
"
RRECOMMENDS_packagegroup-machine-tdx-cli_apalis-imx6 = "\
    bmode-usb \
    gpio-export \
"
RRECOMMENDS_packagegroup-machine-tdx-cli_colibri-imx6 = "\
    bmode-usb \
    gpio-export \
"
RRECOMMENDS_packagegroup-machine-tdx-cli_colibri-imx6ull = "\
    bmode-usb \
    mtd-utils-ubifs \
    mwifiexap \
"
RRECOMMENDS_packagegroup-machine-tdx-cli_colibri-imx6ull-emmc = "\
    bmode-usb \
"
RRECOMMENDS_packagegroup-machine-tdx-cli_colibri-imx7 = "\
    mtd-utils-ubifs \
"
RRECOMMENDS_packagegroup-machine-tdx-cli_verdin-imx8mp = "\
    btuart \
    mwifiexap \
"
RRECOMMENDS_packagegroup-machine-tdx-cli_mx8 = "\
    mwifiexap \
"
RRECOMMENDS_packagegroup-machine-tdx-cli_tegra124 = "\
    hdmi-hotplug \
    kernel-modules \
"

SUMMARY_packagegroup-networking-tdx-cli = "Networking specific tools"
RRECOMMENDS_packagegroup-networking-tdx-cli = "\
    avahi-autoipd \
    curl \
    linuxptp \
    nfs-utils-client \
    ppp \
    ptpd \
"

SUMMARY_packagegroup-utils-tdx-cli = "Useful utilities"

# Entropy source daemon
RANDOM_HELPER = "rng-tools"
RANDOM_HELPER_tegra124 = "haveged"

USB_GADGET = " \
    libusbgx \
    libusbgx-examples \
"
USB_GADGET_tegra124 = ""

RRECOMMENDS_packagegroup-utils-tdx-cli = "\
    alsa-utils \
    alsa-utils-aplay \
    alsa-utils-amixer \
    bluez-alsa \
    bzip2 \
    e2fsprogs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    ethtool \
    gpsd \
    grep \
    lsof \
    minicom \
    mmc-utils-cos \
    pciutils \
    phytool \
    procps \
    ${RANDOM_HELPER} \
    stress-ng \
    sqlite3 \
    tdx-oak-sensors \
    ${USB_GADGET} \
    util-linux \
"
RRECOMMENDS_packagegroup-utils-tdx-cli_append_mx8 = " \
    cpuburn-a53 \
"
RRECOMMENDS_packagegroup-utils-tdx-cli_append_tegra124 = " \
    tegrastats \
"

SUMMARY_packagegroup-utils-large-tdx-cli = "Useful utilities, but large footprint"
RRECOMMENDS_packagegroup-utils-large-tdx-cli = "\
    aspell \
    file \
    joe \
    packagegroup-dotnet-deps \
"

SUMMARY_packagegroup-wifi-tdx-cli = "Useful Wi-Fi utilities and firmware"
BACKPORTS = ""
RRECOMMENDS_packagegroup-wifi-tdx-cli = "\
    ${BACKPORTS} \
    hostapd \
    hostapd-example \
    wireless-regdb-static \
"

SUMMARY_packagegroup-wifi-fw-tdx-cli = "Wi-Fi firmware"
RRECOMMENDS_packagegroup-wifi-fw-tdx-cli = "\
    linux-firmware-ath10k    \
    linux-firmware-nxp89xx   \
    linux-firmware-sd8686    \
    linux-firmware-sd8688    \
    linux-firmware-sd8787    \
    linux-firmware-sd8797    \
    linux-firmware-sd8887    \
    linux-firmware-sd8997    \
    linux-firmware-ralink    \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8188   \
"

SUMMARY_packagegroup-wifi-fw-large-tdx-cli = "Wi-Fi firmware with large footprint"
RRECOMMENDS_packagegroup-wifi-fw-large-tdx-cli = "\
    linux-firmware-ath9k     \
    linux-firmware-iwlwifi   \
"
