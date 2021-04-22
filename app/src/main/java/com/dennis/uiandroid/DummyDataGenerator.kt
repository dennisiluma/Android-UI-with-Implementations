package com.dennis.uiandroid

object DummyDataGenerator {
    fun viewPagerData(): ArrayList<DataViewPager> {
        return arrayListOf(
            (DataViewPager("Dennis", "Debit Card", "$23,095", "2562", "VISA", R.color.blue)),
            (DataViewPager("Hope", "Debit Card", "$23,095", "2562", "VISA", R.color.blue)),
            (DataViewPager("Ola", "Debit Card", "$23,095", "2562", "VISA", R.color.blue)),
            (DataViewPager("Dapo", "Debit Card", "$23,095", "2562", "VISA", R.color.blue)),
            (DataViewPager("femi", "Debit Card", "$23,095", "2562", "VISA", R.color.blue)),
            (DataViewPager("hehehe", "Debit Card", "$23,095", "2562", "VISA", R.color.blue))
        )
    }
}