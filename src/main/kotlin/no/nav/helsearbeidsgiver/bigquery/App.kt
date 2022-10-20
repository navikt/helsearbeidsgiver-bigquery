package no.nav.helsearbeidsgiver.bigquery
import no.nav.helse.rapids_rivers.RapidApplication
import org.slf4j.LoggerFactory

fun main() {
    val logger = LoggerFactory.getLogger("helsearbeidsgiver-bigquery")
    logger.info("biquery sync applikasjon")
    RapidApplication.create(System.getenv()).apply {
        UtsattOppgaveRiver(this)
    }.start()
}
