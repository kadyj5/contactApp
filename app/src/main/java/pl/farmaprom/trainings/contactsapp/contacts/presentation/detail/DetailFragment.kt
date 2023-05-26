package pl.farmaprom.trainings.contactsapp.contacts.presentation.detail

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.ui.MainViewModel
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

class DetailFragment : Fragment() {

    private val viewModel: MainViewModel by navGraphViewModels(R.id.nav)
    private val args: DetailFragmentArgs by navArgs()

    private lateinit var permissionsLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionsLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                requestCall()
            } else {
                Toast.makeText(requireContext(), "abc", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ComposeView>(R.id.compose_view).apply {
            setContent {
                setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
                val contactId = args.id
                val contact: Contact = viewModel.getContactById(contactId)
                ContactsAppTheme {
                    DetailsScreen(
                        contact = contact,
                        onNavigateUp = {
                            findNavController().navigateUp()
                        },
                        onCallRequested = {
                            requestCallWithPermission()
                        }
                    )
                }
            }
        }
    }

    private fun requestCallWithPermission() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED -> {
                requestCall()
            }


            shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE) -> {
                //reason why we need this permission when user disabled it
                Toast.makeText(requireContext(), "Because we need it", Toast.LENGTH_LONG).show()
            }


            else -> permissionsLauncher.launch(Manifest.permission.CALL_PHONE)
        }
    }

    private fun requestCall() {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$123456789")
        }
        startActivity(intent)
    }
}