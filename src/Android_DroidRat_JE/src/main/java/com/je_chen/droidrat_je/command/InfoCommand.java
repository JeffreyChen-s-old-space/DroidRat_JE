package com.je_chen.droidrat_je.command;

import android.content.Context;
import android.content.pm.PackageManager;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.command.process_super.CommandProcessInterface;
import com.je_chen.droidrat_je.rat.modules.appsinfo.getinfo.GetPackagesInfo;


public class InfoCommand extends CommandFather implements CommandProcessInterface {

    private GetPackagesInfo getPackagesInfo;

    public InfoCommand(PackageManager packageManager, Context context){
        getPackagesInfo = new GetPackagesInfo(packageManager,context);
    }

    @Override
    public void send(String value) {

    }

    @Override
    public void processCommand(String command) {

    }
}
