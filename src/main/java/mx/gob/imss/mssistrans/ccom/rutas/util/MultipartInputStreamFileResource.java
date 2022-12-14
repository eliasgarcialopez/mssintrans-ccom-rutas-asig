package mx.gob.imss.mssistrans.ccom.rutas.util;

import org.springframework.core.io.InputStreamResource;

import java.io.IOException;
import java.io.InputStream;

class MultipartInputStreamFileResource extends InputStreamResource {

    // todo - el filename puede no ser necesario
    private final String filename;

    MultipartInputStreamFileResource(InputStream inputStream, String filename) {
        super(inputStream);
        this.filename = filename;
    }

    @Override
    public String getFilename() {
        return this.filename;
    }

    @Override
    public long contentLength() throws IOException {
        return -1; // we do not want to generally read the whole stream into memory ...
    }
}