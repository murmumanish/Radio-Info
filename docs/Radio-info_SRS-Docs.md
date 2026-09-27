# Software Requirements Specification (SRS)

## 1. Project Overview

**Project Name:** Radio Info  
**Document Version:** 1.0.0  
**Date:** 27 September 2026  
**Time:** 7:30 PM IST  
**Author:** Manish Murmu
**Status:** Draft

A minimal Android application that provides a direct shortcut to the Android system activity used to change the preferred mobile network type, such as **5G/NR, LTE/4G, or other modes exposed by the device**.

The app is intended for users who frequently need to switch between network modes because of weak or unstable 5G coverage.

---

## 2. Functional Requirements

### FR-01: Direct Launch

When the user opens the application, it must immediately attempt to launch the configured Android network-settings activity.

There must be **no main screen, dashboard, onboarding, or intermediate UI**.


### FR-02: No Permissions

The application must require **zero Android permissions**.

The application must not request:

- Location permission
- Notification permission
- Notification access
- Accessibility access
- Phone/SMS permissions
- Internet permission
- Any other runtime or special permission

### FR-03: Offline Operation

The launcher itself must not require an internet connection.

### FR-04: No Advertisements

The application must contain **no advertisements or advertising SDKs**.

### FR-05: Privacy

The application must not collect, track, or transmit user data during normal operation.


### FR-06: Launcher Failure Screen

If the application cannot launch the required Settings activity on the user's device, it must display a simple error screen.

Example:

> **This phone is not supported**
>
>  The required network settings activity could not be launched on this device.

The screen should provide an option to submit a bug report.

### FR-04: Bug Report

If the launcher fails, the user must be able to send a bug report.

The bug report should include useful technical information such as:

- Android version
- Device manufacturer
- Device model
- Application version
- Stack Trace Log

The user should be able to review the report before sending it.

No personal information should be collected automatically.

---

## 3. Non-Functional Requirements

### NFR-01: Minimal UI

The application must contain only:

1. Direct launch functionality.
2. A failure screen when the launcher does not work.
3. Bug-report functionality on the failure screen.


### NFR-02: No Background Operation

The application must not run a background service or continuously monitor the cellular network.


### NFR-03: Fast Launch

The application should launch the target Settings activity immediately after being opened, without unnecessary loading screens or processing.

### NFR-04: Android Security

The application must only launch Settings activities that Android legitimately allows a third-party application to launch.

It must not bypass Android security restrictions, require root, or exploit vulnerabilities.

---
## 5. Acceptance Criteria

The application is complete when:

- [x] Opening the app immediately launches the target Settings activity.
- [x] There is no main/home screen.
- [x] The app requires zero permissions.
- [x] The app contains no advertisements.
- [x] The app performs no background monitoring.
- [x] If the Settings activity cannot be launched, an error screen is displayed.
- [ ] The error screen allows the user to submit a bug report.
- [x] The app does not bypass Android security restrictions.
- [x] The launcher works without an internet connection.