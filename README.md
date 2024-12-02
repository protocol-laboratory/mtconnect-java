# mtconnect-java

![License](https://img.shields.io/badge/license-Apache2.0-green) ![Language](https://img.shields.io/badge/language-Java-blue.svg) [![version](https://img.shields.io/github/v/tag/protocol-laboratory/mtconnect-java?label=release&color=blue)](https://github.com/protocol-laboratory/mtconnect-java/releases) [![codecov](https://codecov.io/gh/protocol-laboratory/mtconnect-java/branch/main/graph/badge.svg)](https://codecov.io/gh/protocol-laboratory/mtconnect-java)

### Overview
`mtconnect-java` is a Java sdk for mtconnect.

### Detail
It helps users complete the underlying implementation of Java projects that interface with the mtconnect protocol.
For example, you can use `mtconnect-client` to integrate into Java projects and query information such as Asset and Device through the mtconnect protocol.
You can also use `mtconnect-server` to interface with PLCs, some IoT cloud service platforms, and other devices to obtain specific device information, and establish a simple and easy-to-use server.

When building a complete, it allows users to customize the implementation of MTProcessor to complete more complex functions.
The sample 'MTConnectIoTDAServerExample' has the ability to use Huawei Cloud IoT platform to complete the query of device list.
