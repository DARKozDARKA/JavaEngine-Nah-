package FakeDIContainer;

public class AllServices {
    private static AllServices instance;

    private static final java.util.Map<Class<? extends IService>, Implementation<? extends IService>> ImplementationMap = new java.util.HashMap<>();

    public static AllServices GetInstance() {
        if (instance == null) {
            synchronized (AllServices.class) {
                if (instance == null) {
                    instance = new AllServices();
                }
            }
        }
        return instance;
    }

    public <TService extends IService> void registerSingle(Class<TService> serviceClass, TService implementation) {
        Implementation<TService> impl = new Implementation<>();
        impl.serviceInstance = implementation;
        ImplementationMap.put(serviceClass, impl);
    }

    @SuppressWarnings("unchecked")
    public <TService extends IService> TService single(Class<TService> serviceClass) {
        Implementation<TService> impl = (Implementation<TService>) ImplementationMap.get(serviceClass);
        if (impl == null) {
            throw new IllegalStateException("No service registered for: " + serviceClass.getName());
        }
        return impl.getServiceInstance();
    }

    // Inner class to hold the service instances
    private static class Implementation<TService extends IService> {
        private TService serviceInstance;

        public TService getServiceInstance() {
            return serviceInstance;
        }
    }

}