package model;

public class HealthCheckLogic {
	/**
	 * 身長と体重をもとにBMI指数を算出し、
	 * 体型を判定する。
	 * @param health <br>
	 *   double height, weight, bmi <br>
	 *   String bodyType <br>
	 *   
	 *   最初は身長と体重のみセットされている。
	 *   これに、BMI指数と体型をセット。
	 */
	public void execute(Health health) {
		double weight = health.getWeight();
		double height = health.getHeight() / 100.0;
		double bmi = weight / (height * height);
		health.setBmi(bmi);
		
		String bodyType;
		if (bmi < 18.5) {
			bodyType = "やせ型";
		} else if (bmi < 25) {
			bodyType = "普通";
		} else {
			bodyType = "肥満";
		}
		health.setBodyType(bodyType);
	}

}
