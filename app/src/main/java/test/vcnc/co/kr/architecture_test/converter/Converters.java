package test.vcnc.co.kr.architecture_test.converter;

import android.arch.persistence.room.TypeConverter;

import test.vcnc.co.kr.architecture_test.model.DataStatus;

public class Converters {

    @TypeConverter
    public static DataStatus fromTimestamp(String value) {
        try {
            return DataStatus.valueOf(value);
        } catch (Exception e) {
            return DataStatus.UNKNOWN;
        }
    }

    @TypeConverter
    public static String dateToTimestamp(DataStatus date) {

        if (date != null) {
            return date.toString();
        }
        return null;
    }
}
