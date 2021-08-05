package com.epam.engx.cleancode.naming.task1.collection;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.task1.thirdpartyjar.Submittable;

public class CollectionOrderServiceTestHelper {

    public CollectOrderService getService(){
        return new CollectOrderService();
    }

    public void submit(Submittable collectOrderService) {
        ((CollectOrderService) collectOrderService).submitOrder(new OrderDummy());
    }

    public void setNotificationManager(NotificationManagerMock notificationManagerMock, Submittable collectOrderService) {
        ((CollectOrderService) collectOrderService).setNotificationManager(notificationManagerMock);
    }

    public void setCollectionService(Submittable collectOrderService, CollectionService collectionServiceStub) {
        ((CollectOrderService) collectOrderService).setCollectionService(collectionServiceStub);
    }
}
