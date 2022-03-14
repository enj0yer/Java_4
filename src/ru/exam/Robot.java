package ru.exam;

import java.util.List;

public class Robot<T, R>{
    private List<R> wallets;
    private Checker<T> checker;
    private Action<T, R> action;

    public Robot(Checker<T> checker, Action<T, R> action, List<R> wallets){
        this.wallets = wallets;
        this.checker = checker;
        this.action = action;
    }

    public void check(T item){
        for (var wallet : wallets){
            if (checker.check((item))){
                action.act(item, wallet);
            }
        }
    }
}
