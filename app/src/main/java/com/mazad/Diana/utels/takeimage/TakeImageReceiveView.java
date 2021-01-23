/*
 * Copyright (c) 2020. By Ahmed Noby Ahmed
 */

package com.mazad.Diana.utels.takeimage;

import android.graphics.Bitmap;

import java.io.File;

/**
 * Created by Ahmed Noby Ahmed on 8/4/20.
 */

public interface TakeImageReceiveView {
    void AftergettingImage(Bitmap bitmap, byte[] array, String fileName, File FilePath);
}
