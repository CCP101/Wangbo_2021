package NumChange;

public class Convert {
    public int convertInt(String number) throws ConvertException{
        int num;
        if (number.matches("\\d+")) {
            num = Integer.parseInt(number);
        } else {
            throw new ConvertException("字符串非法");
        }
        return num;
    }
    public double convertDouble(String number) throws ConvertExceptionpublic {
        double num;
        if (number.matches("\\d+?.?\\d+")) {
            num = Double.parseDouble(number);
        } else {
            throw new ConvertExceptionpublic("字符串非法");
        }
        return num;
    }
    float convertFloat(String number) throws ConvertExceptionpublic {
        float num;
        if (number.matches("\\d+?.?\\d+")) {
            num = (float) Double.parseDouble(number);
        } else {
            throw new ConvertExceptionpublic("字符串非法");
        }
        return num;
    }
    short convertShort(String number) throws ConvertExceptiopublic {
        short num;
        if (number.matches("\\d+?.?\\d+")) {
            num = (short) Double.parseDouble(number);
        } else {
            throw new ConvertExceptiopublic("字符串非法");
        }
        return num;
    }
    byte convertByte(String number) throws ConvertException{
        byte num;
        if (number.matches("\\d")) {
            byte[] bytes= number.getBytes();
            num = bytes[0];
        } else {
            throw new ConvertException("字符串非法");
        }
        return num;
    }

    public class ConvertException extends Exception {
        public ConvertException(String message) {
            super(message);
        }
    }

    public class ConvertExceptionpublic extends Exception {
        public ConvertExceptionpublic(String message) {
            super(message);
        }
    }

    public class ConvertExceptiopublic extends Exception {
        public ConvertExceptiopublic(String message) {
            super(message);
        }
    }
}
