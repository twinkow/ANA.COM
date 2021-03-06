package pt.ist.anacom.service;

import pt.ist.anacom.domain.Anacom;
import pt.ist.anacom.shared.dto.BalanceDto;
import pt.ist.anacom.shared.dto.PhoneSimpleDto;
import pt.ist.fenixframework.FenixFramework;

public class GetBalanceService extends AnacomService {

    private PhoneSimpleDto phoneDto;
    private BalanceDto result;

    public GetBalanceService(PhoneSimpleDto phoneDto) {
        this.phoneDto = phoneDto;
    }

    public final void dispatch() {
        Anacom anacom = FenixFramework.getRoot();
        int balance = anacom.getPhoneBalance(phoneDto.getPhoneNumber());
        result = new BalanceDto(balance);
    }

    public BalanceDto getBalanceServiceResult() {
        return this.result;
    }
}
