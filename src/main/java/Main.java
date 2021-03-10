import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Main {

    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        int c = a + b; // 300

        a = 500;
        b = 600;

        // Observable
        // Subscriber (Observer)

        // Observable object
        Observable<String> myObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                int i=0;
                while(i<5) {
                    emitter.onNext("Hello "+i);
                    i++;
                }
                emitter.onComplete();
            }
        });
        // Observer
        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subcribed!!!");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("Get value from Observable: "+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Completed!");
            }
        };
        myObservable.subscribe(myObserver);




    }
}
