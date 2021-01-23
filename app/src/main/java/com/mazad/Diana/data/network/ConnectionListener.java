/*
 * Copyright (c) 2020. By Ahmed Noby Ahmed
 */

package com.mazad.Diana.data.network;

/**
 * Created by Ahmed Noby Ahmed on 8/23/20.
 */

public interface ConnectionListener<T> {

    void onSuccess(ConnectionResponse<T> connectionResponse);

    void onFail(Throwable throwable);
}
