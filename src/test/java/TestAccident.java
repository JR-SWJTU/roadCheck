import com.google.gson.Gson;
import com.swjtu.roadCheck.entityCustom.AccidentQueryCondition;
import com.swjtu.roadCheck.mapper.AccidentMapperCustom;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/10/22.
 */
public class TestAccident {

    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        AccidentMapperCustom accidentMapperCustom = ctx.getBean(AccidentMapperCustom.class);

        AccidentQueryCondition condition = new AccidentQueryCondition();
        condition.setAreaName("金牛区");
        condition.setRoadLevel("高速公路");
        condition.setWeather("晴朗");
        condition.setWorkPlaceRel("否");
        condition.setRoadType("非交叉口");
        condition.setTeanName("大队A");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            condition.setStartTime(format.parse("2017-09-09") );
            condition.setEndTime(format.parse("2017-12-30"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        condition.setCarCollisionType("翻车");
        condition.setTroEscape("否");
        condition.setAreaName("金牛区");
        condition.setIsWorkDay(1);
        condition.setCarType("小客车");

        System.out.println(new Gson().toJson(condition));
        System.out.println(new Gson().toJson(accidentMapperCustom.multiConditionQueryAccidentForSGS(condition)));




    }
}
