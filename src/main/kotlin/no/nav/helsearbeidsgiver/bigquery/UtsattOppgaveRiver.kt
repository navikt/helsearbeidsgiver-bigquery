package no.nav.helsearbeidsgiver.bigquery
import no.nav.helse.rapids_rivers.JsonMessage
import no.nav.helse.rapids_rivers.MessageContext
import no.nav.helse.rapids_rivers.RapidsConnection
import no.nav.helse.rapids_rivers.River
import org.slf4j.LoggerFactory

class UtsattOppgaveRiver(
    rapidsConnection: RapidsConnection
) : River.PacketListener {

    val logg = LoggerFactory.getLogger(this::class.java)
    val sikkerlogg = LoggerFactory.getLogger("tjenestekall")
    val eventName = "utsatt_oppgave_til_bq"

    init {
        River(rapidsConnection).apply {
            validate { it.demandValue("@eventName", eventName) }
        }.register(this)
    }

    override fun onPacket(packet: JsonMessage, context: MessageContext) {
        logg.info("mottok melding med eventName: ${packet["eventName"].asText()}")
        sikkerlogg.info("mottok melding med data: \n${packet.toJson()}")
    }
}
