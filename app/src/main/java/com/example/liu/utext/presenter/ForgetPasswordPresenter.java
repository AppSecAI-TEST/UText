package com.example.liu.utext.presenter;

import com.example.liu.utext.model.ForgetPasswordModel;
import com.example.liu.utext.model.bean.Info;
import com.example.liu.utext.model.bean.User;
import com.example.liu.utext.view.activity.ForgetPasswordActivity;
import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ForgetPasswordPresenter extends BasePresenter<ForgetPasswordModel, ForgetPasswordActivity>{

    @Inject
    public ForgetPasswordPresenter(ForgetPasswordModel model, ForgetPasswordActivity view) {
        super(model, view);
    }

    @Override
    public void requestData(int id, String...info) {
        if (id == 1) {
            mModel.updatePassword(info[0], info[1])
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Info<User>>() {
                        @Override
                        public void accept(@NonNull Info<User> userInfo) throws Exception {
                            if (userInfo.getCode() == 1){
                                mView.showData(1, userInfo.getMessage(), userInfo.getData());
                            }else {
                                mView.showErrorMessage(1, userInfo.getMessage());
                            }
                        }
                    });
        }
    }
}
