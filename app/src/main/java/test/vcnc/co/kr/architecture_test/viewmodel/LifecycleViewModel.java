package test.vcnc.co.kr.architecture_test.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class LifecycleViewModel extends ViewModel {

    private LiveData<String> stateString ;
    private MutableLiveData<List<String>> state = new MutableLiveData<>();

    public LifecycleViewModel() {
        stateString = Transformations.map(state, list -> {
            StringBuilder sb = new StringBuilder();
            for(String state : list ){
                sb.append(state);
            }

            return sb.toString();
        });
    }

    public LiveData<List<String>> getState(){
        return state;
    }

    public LiveData<String> getStateString(){
        return stateString;
    }

    public void addState(String state){
        List<String> stringList = this.getState().getValue();
        if(stringList == null){
            stringList = new ArrayList<>();
        }
        stringList.add(state);
        this.state.postValue(stringList);
    }
}