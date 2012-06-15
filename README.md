pushNotificationService
=======================

apple and android push notification service

General overview:

PushNotification Server runs as a standalone push notification proxy which is requested by backend.
Currently backend implements a PushNotificationDao which provides three ways to initiate a request to
the PushProvider.

To strip out this functionality a single component will be introduced to provide this feature.
backend will communicate via a remote Actor to initiate an application side push request to apple and android
devices.

Components in detail:

A pushreceiver provides a method to dispatch an incoming push request initiated by the backend client to the
appropriate component.
Remote actor (the request coming from the backend) provides the com.entscheidungs.PushReceiver all necessary information to
dispatch the request to the appropriate service.

If the backend requests a push notification for an apple device, the PushServiceActor will redirect this request
to the  ApplePushNotificationService.


Configuration:
The configuration resides in src/main/resources. The application.conf describes the akka components and its way to
communicate between plotbackend , acting as remote client, and PushNotificationService.