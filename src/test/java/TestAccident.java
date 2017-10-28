import com.swjtu.roadCheck.mapper.AccidentMapperCustom;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/10/22.
 */
public class TestAccident {

    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        AccidentMapperCustom accidentMapperCustom = ctx.getBean(AccidentMapperCustom.class);

//        AccidentQueryCondition condition = new AccidentQueryCondition();
//        condition.setAreaName("金牛区");
//        condition.setRoadLevel("高速公路");
//        condition.setWeather("晴朗");
//        condition.setWorkPlaceRel("否");
//        condition.setRoadType("非交叉口");
//        condition.setTeamName("大队A");
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            condition.setStartTime(format.parse("2017-09-09") );
//            condition.setEndTime(format.parse("2017-12-30"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        condition.setCarCollisionType("翻车");
//        condition.setTroEscape("否");
//        condition.setAreaName("金牛区");
//        condition.setIsWorkDay(1);
//        condition.setCarType("小客车");
//
//        System.out.println(new Gson().toJson(condition));
//        System.out.println(new Gson().toJson(accidentMapperCustom.multiConditionQueryAccidentForSGS(condition)));

        String name[] = {"一大队","二大队","二大队"};
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teamName",name);
        System.out.println(jsonObject.toString());

    }
}
