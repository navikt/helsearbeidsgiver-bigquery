package no.nav.helsearbeidsgiver.bigquery
import no.nav.helse.rapids_rivers.RapidApplication
import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal val logger: Logger = LoggerFactory.getLogger("helsearbeidsgiver-bigquery")

fun main() {
    val env = System.getenv()
    val logger = LoggerFactory.getLogger("main")
    logger.info("Start app")
    RapidApplication.create(env).start()
}
