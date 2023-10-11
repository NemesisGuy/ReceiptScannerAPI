package za.co.vsoftsystems.testing;

import java.util.regex.*;

import java.util.List;

public class VisaDataExtractor {
    public static void main(String[] args) {
        List<String> rawDataList = List.of(
                "Precessing SA LTD PTY 0A74320223409 Invoice receipt cun 31/7/2023 Time 14:40 Mrs.LOVENESS CHINTENGO TRR3934777 VISA Category: Residence Temporary Visa Sub VISA Category: TRV Renewal Visa Sub Category: Type Retired Person Visa S ection 20 VISA Fee: 425.00 ZAR 185.00 ZAR Fee: PCC 1550.00 Service ZAR fee: SMS 20 ZAR Fee: (AT: 15% 425. ZAR Total Visa Fees Non Vatable): ( ☐ 00 1550 ZAR Total VFS Fees VAT): {Including",
                "S4 PTY SA Tou Caper Froicessaing CIN CFS Fecopt Iosone CUm ES/2023 11:48 = Time GOTHEKAR HANIF MOHAMMED Mr.ZAID TRC3941397 VISA Category: Visa Residence Temporary exist in TRV - Change VISA Sub Category: conditions visa ing Section Visa Visitors Category: Sub Type 11(6) 0.00 ZAR Fee: VISA 185.00 ZAR Fee: PCC 1550.00 ZAR fee: Service 20 ZAR Fee: SMS 15% VAT: 0.00 ZAR Vatable): Non Visa Fees Total ( 1550 ZAR (Including VAT): Fees UFS Total .00 ZAR VAT/ Total VAS Fees (Including 6 / 00 Sionature Atemt Staff of :",
                "Centre, Facilitation Visa and Permit SA Town Cape LTD PTY SA Processing Visa VFS VAT4320223409 receipt cum Invaice 12:54 Time 21/7/2023 : OKOKO MADZOU HERMAN AUDE Mr. PRP3934051 VISA Category: Permit Residence Permanent PRP VISA Sub Category: 26(b)Spouse Sub Category: Type 0.00 ZAR VISA Fee: 185.00 ZAR Fee: PCC 1550.00 ZAR fee: Service 500.00 ZAR Fee: Premium Lounge 20 ZAR Fee: SMS 15% VAT: 0.00 ZAR Vatable): Non Fees Visa Total { 1550 ZAR VAT): (Including Fees VFS Total .00 ZAR VAT): (Including 705. Fees VAS Total",
                "W74J2022309 Nr.JACQUES DENIE NATONDO NAVOUNGOU TRW3941855 VISA Catecory: Waiver Sub VISA Catenary: TRV-Walve Sub Type Categgryi TRV Waiver VISA Fee: ZAR 0.00 PCC ZAR Fee: 0.00 Service fent ZAR 1550.00 SMS Fee: ZAR 20 VAT:IS% Total Non Vatable): ZAR 0.00 Total 1550"
                // Add more rawData strings here as needed
        );

        for (String rawData : rawDataList) {
            extractName(rawData);
        }
    }

    private static void extractName(String rawData) {
        String pattern = "([A-Z]+( [A-Z]+)+)";

        Matcher matcher = Pattern.compile(pattern).matcher(rawData);

        while (matcher.find()) {
            String name = matcher.group(1);
            System.out.println("Name: " + name);
        }
    }
}