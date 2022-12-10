package platform.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import platform.domain.CodeSnippet;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class CodeService {
    @Autowired
    private CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Transactional
    public CodeSnippet getCodeById(UUID id){
        codeRepository.validateExpiry();
        codeRepository.updateCodeView(id);
        return codeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public CodeSnippet save(CodeSnippet code){
        return codeRepository.save(code);
    }

    @Transactional
    public List<CodeSnippet> getLatest(){
        codeRepository.validateExpiry();
        codeRepository.updateLatestViews(10);
        return codeRepository.getLatest(10);
    }
}
