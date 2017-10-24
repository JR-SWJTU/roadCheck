package com.swjtu.roadCheck.util;

import com.swjtu.roadCheck.entity.Address;
import com.swjtu.roadCheck.entity.AddressExample;
import com.swjtu.roadCheck.mapper.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class AutoDataGenerate {

    @Resource
    private AddressMapper addressMapper;
    @Resource
    private AccidencecollectiondataMapper accidencecollectiondataMapper;
    @Resource
    private AccidentdataMapper accidentdataMapper;
    @Resource
    private EmdataMapper emdataMapper;
    @Resource
    private CardataMapper cardataMapper;
    @Resource
    private DriverPeoPelDataMapper driverPeoPelDataMapper;
    @Resource
    private ChenzuoPeopelDataMapper chenzuoPeopelDataMapper;
    @Resource
    private QitaPeopelDataMapper qitaPeopelDataMapper;

    public void start(){
        String[] name = {"一段","二段","三段","四段","五段","六段","七段","八段","九段","十段"};

        double lngIncreament = 0.005;
        double latIncreament = 0.01;
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().getAllCriteria();
        List<Address> addressList = new ArrayList<Address>();
        for (int i = 1 ; i <= 10; i++) {
            Address address = new Address();
            address = addressMapper.selectByPrimaryKey(i);
            addressList.add(address);
            System.out.println("addresslist size"+addressList.size());
        }
       // System.out.println("addresslist size"+addressList.size());
    }
    public static void main(String[] args) {
        AutoDataGenerate autoDataGenerate = new AutoDataGenerate();
        autoDataGenerate.start();
    }
}
