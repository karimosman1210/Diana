package com.mazad.Diana.gui.common.home

import com.mazad.Diana.data.AdsModel

interface HomeInterface {
        fun noConnection()
        fun sucuss(adsList:ArrayList<AdsModel>)
        fun onCancelled()
}