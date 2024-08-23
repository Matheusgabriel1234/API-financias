package desafio.matheus.desafio_tabela_financias.service;



import org.springframework.stereotype.Service;

import desafio.matheus.desafio_tabela_financias.entities.DataUser;
import desafio.matheus.desafio_tabela_financias.entities.FinanceData;
import desafio.matheus.desafio_tabela_financias.repository.FinanceRepository;
import desafio.matheus.desafio_tabela_financias.repository.UserRepository;

@Service
public class FinanceService {

private UserRepository userRepo;

private FinanceRepository financeRepo;

public FinanceService(UserRepository userRepo, FinanceRepository financeRepo) {
	super();
	this.userRepo = userRepo;
	this.financeRepo = financeRepo;
}






public FinanceData addFinancialData(Long userId, FinanceData financialData) {
        DataUser user = userRepo.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        financialData.setUserId(user);
        userRepo.save(user);
        return financeRepo.save(financialData);
    }


	
	

}
