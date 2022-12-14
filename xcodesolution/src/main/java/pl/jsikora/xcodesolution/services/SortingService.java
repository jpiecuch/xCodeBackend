package pl.jsikora.xcodesolution.services;

import org.springframework.stereotype.Service;
import pl.jsikora.xcodesolution.dto.RequestNumbersDTO;
import pl.jsikora.xcodesolution.dto.ResponseNumbersDTO;
import pl.jsikora.xcodesolution.exceptions.BadOrderException;

import java.util.Comparator;
import java.util.List;

@Service
public class SortingService {

    public ResponseNumbersDTO sortNumbers(RequestNumbersDTO requestNumbers) {

        List<Integer> tempNumbers = requestNumbers.getNumbers();

        if (tempNumbers != null) {
            if ("ASC".equals(requestNumbers.getOrder())) tempNumbers.sort(Comparator.naturalOrder());
            else if ("DESC".equals(requestNumbers.getOrder())) tempNumbers.sort(Comparator.reverseOrder());
            else throw new BadOrderException("Bad order type, only 'ASC' or 'DESC' allowed.");
        }
        return new ResponseNumbersDTO(tempNumbers);
    }
}
