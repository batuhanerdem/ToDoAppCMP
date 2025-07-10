import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
     @UIApplicationDelegateAdaptor(AppDelegate.self)
     var appDelegate: AppDelegate

    var body: some Scene {
        WindowGroup {
             RootView(root: appDelegate.root)
                .ignoresSafeArea(.keyboard)
//            ContentView().ignoresSafeArea(.keyboard)
        }
    }
}
class AppDelegate: NSObject, UIApplicationDelegate {
    let root: RootComponent

    override init() {
         
        KoinAppKt.doInitKoin()

        // Lifecycle-aware component
        root = RootComponentImpl(componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle()))
    }
}
