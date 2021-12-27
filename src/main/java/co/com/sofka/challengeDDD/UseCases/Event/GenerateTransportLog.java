package co.com.sofka.challengeDDD.UseCases.Event;

import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;

public interface GenerateTransportLog {
    boolean generate(TransportId transportId, String log);
}
