package anotherOne.main.trash;

import java.util.Observable;
import java.util.Observer;

// First observer
class FirstNewsReader implements Observer {
	public void update(Observable obj, Object arg) {
		System.out.println("FirstNewsReader got The news:"+(String)arg);
	}
}

//Second Observer
class SecondNewsReader implements Observer {
	public void update(Observable obj, Object arg) {
		System.out.println("SecondNewsReader got The news:"+(String)arg);
	}
}

// This is the class being observed.
class News extends Observable {
	void news() {
		String[] news = {"News 1", "News 2", "News 3"};
		for(String s: news){
			//set change
			setChanged();
			//notify observers for change
			notifyObservers(s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Error Occurred.");
			}
		}
	}
}

//Run Observer and Observable
class ObserverObservableDemo {
	public static void main(String args[]) {
		News observedNews = new News();
		FirstNewsReader reader1 = new FirstNewsReader();
		SecondNewsReader reader2 = new SecondNewsReader();
		observedNews.addObserver(reader1);
		observedNews.addObserver(reader2);
		observedNews.news();
	}
}