import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
   // let shareComponent =  ShareComponent().repository
    //let title = ShareComponent().title
	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
