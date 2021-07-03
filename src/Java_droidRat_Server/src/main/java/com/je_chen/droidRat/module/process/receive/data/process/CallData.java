package com.je_chen.droidRat.module.process.receive.data.process;

import com.je_chen.droidRat.module.process.receive.data.process_super.DataFather;

public class CallData extends DataFather {

    @Override
    public void processData(String[] dataArray) {
        switch (dataArray[1]) {

            case "CallPhone":
                System.out.println(dataArray[1] + " : " + dataArray[2]);
                break;

            case "CallLogs":
                System.out.println(dataArray[1]);
                System.out.println("Phone Number: " + dataArray[2]);
                System.out.println("Direction: " + dataArray[3]);
                System.out.println("Call Duration: " + dataArray[4]);
                System.out.println("Call Day Times: " + dataArray[5]);
                break;
        }
    }
}
