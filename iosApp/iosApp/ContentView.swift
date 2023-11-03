import SwiftUI
import shared
import UIKit

//struct ContentView: View {
//    @ObservedObject private(set) var viewModel: ViewModel
//
//    var body: some View {
//        List(viewModel.phrases, id: \.self) { phrase in
//            Text(phrase)
//        }
//    }
//}
struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.all, edges: .bottom) // Compose has own keyboard handler
    }
}
struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        Platform_iosKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
//extension ContentView {
//    class ViewModel: ObservableObject {
//        @Published var phrases: [String] = ["Loading..."]
//        init() {
//            // Data will be loaded here
//                Greeting().greet { greeting, error in
//                    DispatchQueue.main.async {
//                        if let greeting = greeting {
//                            self.phrases = greeting
//                        } else {
//                            self.phrases = [error?.localizedDescription ?? "error"]
//                        }
//                    }
//                }
//                }
//    }
//}
