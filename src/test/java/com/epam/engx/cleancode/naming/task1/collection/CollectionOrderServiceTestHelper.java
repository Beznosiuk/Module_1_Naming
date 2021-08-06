package com.epam.engx.cleancode.naming.task1.collection;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Submittable;

public class CollectionOrderServiceTestHelper {

    public CollectionOrderService getService(){
        return new CollectionOrderService();
    }

    public void submit(Submittable collectOrderService) {
        ((CollectionOrderService) collectOrderService).submitOrder(new OrderDummy());
    }

    public void setNotificationManager(NotificationManagerMock notificationManagerMock, Submittable collectOrderService) {
        ((CollectionOrderService) collectOrderService).setNotificationManager(notificationManagerMock);
    }

    public void setCollectionService(Submittable collectOrderService, CollectionService collectionServiceStub) {
        ((CollectionOrderService) collectOrderService).setCollectionService(collectionServiceStub);
    }
}
