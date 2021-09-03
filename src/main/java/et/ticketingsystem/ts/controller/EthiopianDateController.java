package et.ticketingsystem.ts.controller;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andegna.chrono.EthiopianDate;

import et.ticketingsystem.ts.model.User;
import et.ticketingsystem.ts.util.UserNotFoundExcption;

@RestController
public class EthiopianDateController {

	@GetMapping("/getNow")
	public String geNow() {
		EthiopianDate now = EthiopianDate.now();
		return now.get(ChronoField.DAY_OF_MONTH) + "/" + now.get(ChronoField.MONTH_OF_YEAR) + "/"
				+ now.get(ChronoField.YEAR_OF_ERA);
		// System.out.println(ethiopianDate.format(DateTimeFormatter.ISO_DATE));

	}

	@GetMapping("/getGC")
	public String geGC(@RequestParam String _date) {

		try {
			int _date_day = Integer.parseInt(_date.split("/")[0]);
			int _date_month = Integer.parseInt(_date.split("/")[1]);
			int _date_year = Integer.parseInt(_date.split("/")[2]);
			EthiopianDate tmp = EthiopianDate.of(_date_year, _date_month, _date_day);
		
			return tmp.format(DateTimeFormatter.ISO_DATE);//tmp.get(ChronoField.DAY_OF_MONTH) + "/" + tmp.get(ChronoField.MONTH_OF_YEAR) + "/"
					//+ tmp.get(ChronoField.YEAR_OF_ERA);
           
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	@GetMapping("/getEC")
	public String geEC(@RequestParam String _date) {
		try {
			int _date_day = Integer.parseInt(_date.split("/")[0]);
			int _date_month = Integer.parseInt(_date.split("/")[1]);
			int _date_year = Integer.parseInt(_date.split("/")[2]);
			EthiopianDate tmp = EthiopianDate.of(_date_year, _date_month, _date_day);
			return tmp.format(DateTimeFormatter.ISO_DATE);
           
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
