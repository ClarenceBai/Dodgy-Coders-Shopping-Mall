package ie.ucd.dodgycoders.paymentservice.api.repository;

import ie.ucd.dodgycoders.paymentservice.api.model.Payment;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;


@Document("paymentRecords")
public class paymentRecords extends Payment{
    public Date date;
    public static int paymentId = 0;

    public static paymentRecords factory(Payment payment){
        paymentRecords paymentr = new paymentRecords();
        BeanUtils.copyProperties(payment, paymentr, "paymentPlacedTime");
        paymentr.date = new Date();
        paymentId++;
        return paymentr;
    }
}
